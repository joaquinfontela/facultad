import React from 'react'
import "./UpdateWindow.css"
import SubjectCheckbox from "./SubjectCheckbox/SubjectCheckbox"
import ApiHandler from '../../API/ApiHandler'


interface UpdateWindowState {
    passedSubjectsCodes: string[],
    failedSubjectsCodes: string[],
    data: any
}

interface UpdateWindowProps {
    studentId: string
    carreerId: number
}

interface Subject {
    code: string,
    name: string,
    credits: number
}


export class UpdateWindow extends React.Component<UpdateWindowProps, UpdateWindowState> {

    constructor(props: any) {
        super(props);
        this.state = {
            passedSubjectsCodes: [],
            failedSubjectsCodes: [],
            data: {}
        }
        this.handlePassedClick = this.handlePassedClick.bind(this);
        this.handleFailedClick = this.handleFailedClick.bind(this);
    }

    handlePassedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!passed.includes(subjectCode)) {
            passed.push(subjectCode);
            if (failed.includes(subjectCode)) {
                failed.splice(failed.indexOf(subjectCode), 1);
            }
        }
        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    handleFailedClick(subjectCode: string): void {
        let passed: string[] = this.state.passedSubjectsCodes;
        let failed: string[] = this.state.failedSubjectsCodes;

        if (!failed.includes(subjectCode)) {
            failed.push(subjectCode);
            if (passed.includes(subjectCode)) {
                passed.splice(passed.indexOf(subjectCode), 1);
            }
        }

        this.setState({
            passedSubjectsCodes: passed,
            failedSubjectsCodes: failed
        })
    }

    handleUpdateClick() {
        const studentData: object = {
            passed: this.state.passedSubjectsCodes,
            failed: this.state.failedSubjectsCodes
        }
        new ApiHandler().sendData(this.props.studentId, studentData);
    }

    componentDidMount(): void {
        new ApiHandler().getStudentData(this.props.studentId).then((d: any) => {
            let passedSubjectsCodes: string[] = JSON.parse(d).data[this.props.carreerId].passed.map((sub: Subject) => {
                return sub.code;
            });
            this.setState({
                data: JSON.parse(d),
                passedSubjectsCodes,
                failedSubjectsCodes: this.getAllSubjectCodes(d).filter((sub: string) => {
                    return !passedSubjectsCodes.includes(sub);
                })
            });
        });
    }

    getAllSubjectCodes(d: string): string[] {
        const data: any = JSON.parse(d);
        const available: Subject[] = data.data[this.props.carreerId].available;
        const left: any = data.data[this.props.carreerId].left;
        const passed: Subject[] = data.data[this.props.carreerId].passed;
        const availableCodes: string[] = available.map((s: Subject) => s.code);
        const leftCodes: any = Object.keys(left).filter((subCode: string) => {
            return !availableCodes.includes(subCode);
        });
        const passedCodes: string[] = passed.map((s: Subject) => s.code);
        return availableCodes.concat(leftCodes.concat(passedCodes));
    }

    render(): JSX.Element {
        if (!this.state.data.data || this.props.carreerId === 12) {
            return (<div></div>);
        }
        const available: Subject[] = this.state.data.data[this.props.carreerId].available;
        const left: any = this.state.data.data[this.props.carreerId].left;
        const passed: Subject[] = this.state.data.data[this.props.carreerId].passed;

        const availableCodes: string[] = available.map((s: Subject) => s.code);
        const leftCodes: any = Object.keys(left).filter((subCode: string) => {
            return !availableCodes.includes(subCode);
        });
        const passedCodes: string[] = passed.map((s: Subject) => s.code);
        const subjectCodes: string[] = availableCodes.concat(leftCodes.concat(passedCodes));

        subjectCodes.sort(function (a: string, b: string) {
            var keyA: number = Number(a);
            var keyB: number = Number(b);
            if (keyA < keyB) return -1;
            if (keyA > keyB) return 1;
            return 0;
        })

        const subjectCheckboxes: JSX.Element[] = subjectCodes.map((s: string) => {
            return (
                <SubjectCheckbox key={s}
                    code={s}
                    passed={this.state.passedSubjectsCodes.includes(s)}
                    failed={this.state.failedSubjectsCodes.includes(s)}
                    handlePassedClick={this.handlePassedClick}
                    handleFailedClick={this.handleFailedClick} />
            );
        })

        let subjectCheckboxesList1: any[] = [];
        let subjectCheckboxesList2: any[] = [];
        let subjectCheckboxesList3: any[] = [];
        let subjectCheckboxesList4: any[] = [];
        let listToAdd: number = 1;

        while (!(subjectCheckboxes.length === 0)) {

            switch (listToAdd) {
                case 1:
                    subjectCheckboxesList1.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                case 2:
                    subjectCheckboxesList2.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                case 3:
                    subjectCheckboxesList3.push(subjectCheckboxes.shift());
                    listToAdd += 1;
                    break;
                default:
                    subjectCheckboxesList4.push(subjectCheckboxes.shift());
                    listToAdd = 1;
                    break;
            }
        }

        return (
            <div>
                <button className="updateButton" onClick={() => { }}>ACTUALIZAR</button>
                <hr></hr>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList1}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList2}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList3}</ul>
                </div>
                <div>
                    <ul className="subjectCheckboxList">{subjectCheckboxesList4}</ul>
                </div>
            </div >
        );
    }
}
